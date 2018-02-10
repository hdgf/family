package com.universe.family.controller;

import com.universe.family.annotation.Authes;
import com.universe.family.annotation.CurrentMember;
import com.universe.family.config.Constants;
import com.universe.family.model.TokenModel;
import com.universe.family.model.cronous.game.*;
import com.universe.family.model.cronous.game.CharacterPack;
import com.universe.family.model.cronous.game.InventoryBean;
import com.universe.family.model.cronous.game.PersonalAccount;
import com.universe.family.model.cronous.member.Member;
import com.universe.family.model.cronous.member.MemberRepository;
import com.universe.family.model.cronous.member.UserPoint;
import com.universe.family.model.cronous.member.UserPointRepository;
import com.universe.family.model.cronous.season2.*;
import com.universe.family.model.cronous.shop.GameConut;
import com.universe.family.model.cronous.shop.GameConutRepository;
import com.universe.family.model.cronous.shop.WebShop;
import com.universe.family.model.cronous.shop.WebShopRepository;
import com.universe.family.model.net.ResultModel;
import com.universe.family.utils.ResultStatus;
import com.universe.family.utils.RoleData;
import com.universe.family.utils.RoleData2;
import com.universe.family.utils.TokenManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cro")
@Api(value = "Cronous Member API", description = "Member Management, including reg/login etc")
public class MemberController {
    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PaRepository paRepository;

    @Autowired
    private PackRepository packRepository;

    @Autowired
    private CpRepository cpRepository;

    @Autowired
    private CbRepository cbRepository;

    @Autowired
    private Data2Repository data2Repository;

    @Autowired
    private Inven2Repository inven2Repository;

    @Autowired
    private InvenRepository invenRepository;

    @Autowired
    BottomRepository bottomRepository;

    @Autowired
    DataRepository dataRepository;

    @Autowired
    UserPointRepository userPointRepository;

    @Autowired
    WebShopRepository webShopRepository;

    @Autowired
    GameConutRepository gameConutRepository;

    @GetMapping(value = "all")
    @ApiOperation(value="玩家列表")
    public ResponseEntity<ResultModel> findAll() {
        List<Member> members = memberRepository.findAll();
        if (members.size()==0) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(members), HttpStatus.OK);
    }

    @GetMapping(value = "find/{username}")
    @ApiOperation(value="查找玩家")
    public ResponseEntity<ResultModel> findById(@PathVariable String username) {
        Member member = memberRepository.findByUserid(username);
        if (member == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(member), HttpStatus.OK);
    }

    @GetMapping(value = "findPoint/{username}")
    @ApiOperation(value="查找玩家道具点")
    public ResponseEntity<ResultModel> findPoint(@PathVariable String username) {
        UserPoint userPoint = userPointRepository.findUserPointByUserName(username);
        if (userPoint == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        // Must be List, don't know why?
        List<UserPoint> retList = new ArrayList<>();
        retList.add(userPoint);

        return new ResponseEntity<>(ResultModel.ok(retList), HttpStatus.OK);
        //return new ResponseEntity<>(ResultModel.ok(userPoint), HttpStatus.OK);
    }

    @RequestMapping(value = "updatePoint", method = RequestMethod.POST)
    @ApiOperation(value="更新玩家道具点")
    public ResponseEntity<ResultModel> updatePoint(@RequestParam String username, @RequestParam int point) {
        userPointRepository.updatePoint(username,point);
        return new ResponseEntity<>(ResultModel.ok("Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "buyGoods", method = RequestMethod.POST)
    @ApiOperation(value="购买道具")
    public ResponseEntity<ResultModel> buyGoods(@RequestParam String username, @RequestParam int ckey,
                                                @RequestParam int needpoint,@RequestParam String bitemid) {
        // find the position to hold goods
        String strInvenPos = "5354555657";
        List<InventoryBean> inventoryBeanList = invenRepository.findByChkey(ckey);
        for(InventoryBean inventoryBean : inventoryBeanList) {
            strInvenPos = strInvenPos.replace(String.valueOf(inventoryBean.getInventorypos()),"");
        }
        if(strInvenPos.length()==0) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NO_INVEN_SPACE), HttpStatus.NOT_FOUND);
        }else {
            strInvenPos = strInvenPos.substring(0,2);
        }

        System.out.println("buyGoods inventory pos:" +  strInvenPos);

        // insert inventory using web shop goods
        WebShop webShop = webShopRepository.findByBitemid(bitemid);
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setChkey(ckey);
        inventoryBean.setInventorypos(Integer.valueOf(strInvenPos));
        inventoryBean.setAmount(Integer.valueOf(webShop.getAmount().trim()));
        inventoryBean.setBitemid(Integer.valueOf(bitemid));
        inventoryBean.setUpgradepoint(Integer.valueOf(webShop.getUpgradePoint()));
        inventoryBean.setColor(Integer.valueOf(webShop.getColor()));
        inventoryBean.setGade(Integer.valueOf(webShop.getGrade()));
        inventoryBean.setDurability(Integer.valueOf(webShop.getDurability()));
        inventoryBean.setSerialt(Long.valueOf(webShop.getSerialt()));

        List<GameConut> gameConut = gameConutRepository.findAll();
        inventoryBean.setSerialc(gameConut.get(0).getItemConut());//标识码
        System.out.println("buyGoods gameConut:" +  gameConut.get(0).getItemConut());

        inventoryBean.setLimitation(Integer.valueOf(webShop.getLimitation()));
        inventoryBean.setDamage_values0(Integer.valueOf(webShop.getDamage_values0()));
        inventoryBean.setDamage_values1(Integer.valueOf(webShop.getDamage_values1()));
        inventoryBean.setDamage_values2(Integer.valueOf(webShop.getDamage_values2()));
        inventoryBean.setDamage_values3(Integer.valueOf(webShop.getDamage_values3()));
        inventoryBean.setDamage_values4(Integer.valueOf(webShop.getDamage_values4()));
        inventoryBean.setDamage_values5(Integer.valueOf(webShop.getDamage_values5()));
        inventoryBean.setDamage_values6(Integer.valueOf(webShop.getDamage_values6()));
        inventoryBean.setDamage_values7(Integer.valueOf(webShop.getDamage_values7()));
        inventoryBean.setOptionId0(Integer.valueOf(webShop.getOptionId0()));
        inventoryBean.setOptionId1(Integer.valueOf(webShop.getOptionId1()));
        inventoryBean.setOptionId2(Integer.valueOf(webShop.getOptionId2()));
        inventoryBean.setOptionId3(Integer.valueOf(webShop.getOptionId3()));
        inventoryBean.setOptionId4(Integer.valueOf(webShop.getOptionId4()));
        inventoryBean.setOptionId5(Integer.valueOf(webShop.getOptionId5()));
        inventoryBean.setOptionId6(Integer.valueOf(webShop.getOptionId6()));
        inventoryBean.setOptionId7(Integer.valueOf(webShop.getOptionId7()));
        invenRepository.save(inventoryBean);

        gameConutRepository.delete(gameConut.get(0).getItemConut());
        GameConut gameConut1 = new GameConut(gameConut.get(0).getItemConut()+1);
        gameConutRepository.save(gameConut1);

        // subtract point from user point
        userPointRepository.updatePoint(username,-1*needpoint);

        return new ResponseEntity<>(ResultModel.ok("Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "reg", method = RequestMethod.POST)
    @ApiOperation(value="玩家注册")
    public ResponseEntity<ResultModel> addMember(@RequestParam String username, @RequestParam String password,
                                                 @RequestParam String email) {
        Member member = memberRepository.findByUserid(username);
        if(member != null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USER_EXISTS), HttpStatus.FOUND);
        }
        
        member = memberRepository.save(new Member(username,password,email,"127.0.0.1", "sys",new Date()));

        if (member == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USER_ADDS), HttpStatus.FOUND);
        }

        gameRepository.save(new PersonalAccount(username, 0,0,0, new Date()));

        paRepository.save(new com.universe.family.model.cronous.season2.PersonalAccount(username, 0,0,0, new Date()));

        userPointRepository.save(new UserPoint(username,0,0,0,0,0,0,0,0,new Date()));

        // Must be List, don't know why?
        List<Member> retList = new ArrayList<>();
        retList.add(member);

        return new ResponseEntity<>(ResultModel.ok(retList), HttpStatus.OK);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value="玩家登陆")
    public ResponseEntity<ResultModel> login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        Member member = memberRepository.findByUserid(username);
        if (member == null || !member.getPasswd().trim().equals(password)) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }

        // if the user logged in, delete it in Redis firstly
        if(tokenManager.IsInRedis(String.valueOf(member.getNo()))) {
            tokenManager.deleteToken(String.valueOf(member.getNo()));
        }

        TokenModel model = tokenManager.createToken(String.valueOf(member.getNo()));

        UserPoint res = userPointRepository.findUserPointByUserName(username);
        model.setType(Constants.common);

        if(res.getPoint() >=1500 && res.getPoint()<3000)
            model.setType(Constants.copper);
        if(res.getPoint() >=3000 && res.getPoint()<6000)
            model.setType(Constants.silver);
        if(res.getPoint() >=6000 && res.getPoint()<15000)
            model.setType(Constants.gold);
        if(res.getPoint() >=15000)
            model.setType(Constants.extreme);

        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }

    @RequestMapping(value = "logout", method = RequestMethod.DELETE)
    @Authes
    @ApiOperation(value = "退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<ResultModel> logout(@CurrentMember Member member) {

        // if the user logged in, delete it in Redis firstly
        if(tokenManager.IsInRedis(String.valueOf(member.getNo()))) {
            tokenManager.deleteToken(String.valueOf(member.getNo()));
            System.out.println("logout:" + member.getNo() +"_"+ member.getUserid());
        }
        else {
            System.out.println("logout:" + member.getNo() +" doesn't login yet!");
        }

        return new ResponseEntity<>(ResultModel.ok("Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "del_self", method = RequestMethod.DELETE)
    @Authes
    @ApiOperation(value="删除自己账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),})
    public ResponseEntity<ResultModel> delSelf(@CurrentMember Member member) {
        tokenManager.deleteToken(String.valueOf(member.getNo()));

        String username = member.getUserid();

        if(gameRepository.findByUserid(username) != null) {
            gameRepository.deleteByUserid(username);
        }

        memberRepository.delete(member);

        return new ResponseEntity<>(ResultModel.ok("Success"), HttpStatus.OK);
    }

    @GetMapping(value = "role_self")
    @Authes
    @ApiOperation(value="获取角色数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),})
    public ResponseEntity<ResultModel> roleSelf(@CurrentMember Member member) {

        String user = member.getUserid();

        // Verify if the user exists, if sure, return person id.
        PersonalAccount personalAccount = gameRepository.findByUserid(user);
        if (personalAccount == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        // Get role list belongs to the specified user.
        List<CharacterPack> characterPacks = packRepository.findByPersonid(personalAccount.getPersonkey());
        if (characterPacks == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(getRoleData(characterPacks)), HttpStatus.OK);
    }

    @RequestMapping(value = "del", method = RequestMethod.DELETE)
    @ApiOperation(value="删除玩家账号")
    public ResponseEntity<ResultModel> delMember(@RequestParam String username) {
        if(memberRepository.findByUserid(username) != null) {
            memberRepository.deleteByUserid(username);
        }
        if(gameRepository.findByUserid(username) != null) {
            gameRepository.deleteByUserid(username);
        }

        return new ResponseEntity<>(ResultModel.ok("Success"), HttpStatus.OK);
    }

    @GetMapping(value = "role/{user}")
    @ApiOperation(value="获取角色数据")
    public ResponseEntity<ResultModel> role(@PathVariable String user) {
        // Verify if the user exists, if sure, return person id.
        PersonalAccount personalAccount = gameRepository.findByUserid(user);
        if (personalAccount == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        // Get role list belongs to the specified user.
        List<CharacterPack> characterPacks = packRepository.findByPersonid(personalAccount.getPersonkey());
        if (characterPacks == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(getRoleData(characterPacks)), HttpStatus.OK);
    }

    private List<RoleData> getRoleData(List<CharacterPack> characterPacks) {

        List<RoleData> roleDataList = new ArrayList<>();

        for(CharacterPack characterPack: characterPacks) {
            RoleData roleData = new RoleData(characterPack);
            roleData.setCharacterBottom(bottomRepository.findByCKey(characterPack.getCkey()));
            roleData.setDataBean(dataRepository.findByCkey(characterPack.getCkey()));
            roleData.setInventoryBeans(invenRepository.findByChkeyOrderByInventorypos(characterPack.getCkey()));
            roleDataList.add(roleData);
        }

        return roleDataList;
    }

    @GetMapping(value = "role2/{user}")
    @ApiOperation(value="获取2季角色数据")
    public ResponseEntity<ResultModel> role2(@PathVariable String user) {
        // Verify if the user exists, if sure, return person id.
        com.universe.family.model.cronous.season2.PersonalAccount personalAccount = paRepository.findByUserid(user);
        if (personalAccount == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        // Get role list belongs to the specified user.
        List<com.universe.family.model.cronous.season2.CharacterPack> characterPacks =
                cpRepository.findByPersonid(personalAccount.getPersonkey());
        if (characterPacks == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(getRoleData2(characterPacks)), HttpStatus.OK);
    }

    private List<RoleData2> getRoleData2(List<com.universe.family.model.cronous.season2.CharacterPack> characterPacks) {

        List<RoleData2> roleDataList = new ArrayList<>();

        for(com.universe.family.model.cronous.season2.CharacterPack characterPack: characterPacks) {
            RoleData2 roleData = new RoleData2(characterPack);
            roleData.setCharacterBottom(cbRepository.findByCKey(characterPack.getCkey()));
            roleData.setDataBean(data2Repository.findByCkey(characterPack.getCkey()));
            roleData.setInventoryBeans(inven2Repository.findByChkeyOrderByInventorypos(characterPack.getCkey()));
            roleDataList.add(roleData);
        }

        return roleDataList;
    }
}