package com.universe.family.controller;

import com.universe.family.model.cronous.shop.*;
import com.universe.family.model.net.ResultModel;
import com.universe.family.utils.PageableTools;
import com.universe.family.utils.ResultStatus;
import com.universe.family.utils.SortDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private WebShopRepository webShopRepository;

    @Autowired
    private WebNewsRepository webNewsRepository;

    @Autowired
    private AppVersRepository appVersRepository;

    @GetMapping(value = "all")
    @ApiOperation(value="获取所有商品")
    public ResponseEntity<ResultModel> allWebShop() {
        List<WebShop> webShops =  webShopRepository.findAll();

        if (webShops == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(webShops), HttpStatus.OK);
    }

    @GetMapping(value = "find/{type}/{page}/{size}")
    @ApiOperation(value="获取某类所有商品")
    public ResponseEntity<ResultModel> findByCat(@PathVariable String type, @PathVariable int page,
                                                 @PathVariable int size) throws UnsupportedEncodingException {
        Page<WebShop> webShops1;
        List<WebShop> webShops = new ArrayList<>();

        if("all".equals(type.toLowerCase().trim())) {
            webShops1 = webShopRepository.findAllByType("baoshi", PageableTools.basicPage(page, size, new SortDto("time")));
            if(webShops1 != null && webShops1.getSize() > 0 ) {
                for(WebShop w : webShops1) {
                        webShops.add(w);
                }
            }
            webShops1 = webShopRepository.findAllByType("wuqizhuangbei", PageableTools.basicPage(page, size, new SortDto("time")));
            if(webShops1 != null && webShops1.getSize() > 0 ) {
                for(WebShop w : webShops1) {
                        webShops.add(w);
                }
            }
        } else {
            webShops1 = webShopRepository.findAllByType(type, PageableTools.basicPage(page, size, new SortDto("time")));
            if(webShops1 != null && webShops1.getSize() > 0 ) {
                for(WebShop w : webShops1) {
                        webShops.add(w);
                }
            }
        }

        return new ResponseEntity<>(ResultModel.ok(webShops), HttpStatus.OK);
    }

    @GetMapping(value = "getTui/{id}/{time}")
    @ApiOperation(value="获取某类视频")
    public ResponseEntity<ResultModel> getTui(@PathVariable String id, @PathVariable String time) throws UnsupportedEncodingException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WebShop> webShops = null;
        try {
            webShops = webShopRepository.findByTypeAndTime(id,sdf.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (webShops == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(webShops), HttpStatus.OK);
    }

    @GetMapping(value = "fuzzy/{itemname}/{page}/{size}")
    @ApiOperation(value="根据物品名字模糊查找")
    public ResponseEntity<ResultModel> fuzzyByName(@PathVariable String itemname, @PathVariable int page,
                                                   @PathVariable int size) throws UnsupportedEncodingException {
        String pString = "%" + itemname + "%";

        Page<WebShop> webShops =  webShopRepository.findByName(pString,PageableTools.basicPage(page,size, new SortDto("time")));
        if (webShops == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        List<WebShop> resultList = new ArrayList<>();
        for(WebShop webShop : webShops) {
            resultList.add(webShop);
        }

        return new ResponseEntity<>(ResultModel.ok(resultList), HttpStatus.OK);
    }

    @GetMapping(value = "fuzzyNews/{hint}/{page}/{size}")
    @ApiOperation(value="模糊查询新闻")
    public ResponseEntity<ResultModel> findNewsByHint(@PathVariable String hint, @PathVariable int page,
                                                      @PathVariable int size) throws UnsupportedEncodingException {
        List<WebNews> webNewsAll = new ArrayList<>();
        List<Long> idList = new ArrayList<>();

        Page<WebNews> webNews1 =  webNewsRepository.findAllByTitle("%" + hint+"%",PageableTools.basicPage(page,size, new SortDto("time")));

        Page<WebNews> webNews2 =  webNewsRepository.findAllByInfo("%" + hint+"%",PageableTools.basicPage(page,size, new SortDto("time")));

        if (webNews1 == null &&  webNews2 == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        if(webNews1 != null && webNews1.getSize() > 0 ) {
            for(WebNews u: webNews1) {
                webNewsAll.add(u);
                idList.add((long) u.getId());
            }
        }

        if(webNews2 != null && webNews2.getSize() > 0 ) {
            for(WebNews w: webNews2) {
                // 去重复的记录
                if(!idList.contains((long)w.getId()))
                    webNewsAll.add(w);
            }
        }

        return new ResponseEntity<>(ResultModel.ok(webNewsAll), HttpStatus.OK);
    }

    @GetMapping(value = "findNewsPerPage/{type}/{page}/{size}")
    @ApiOperation(value="分页获取某类所有新闻")
    public ResponseEntity<ResultModel> findNewsByTypePerPage(@PathVariable String type, @PathVariable int page,
                                                             @PathVariable int size) throws UnsupportedEncodingException {
        List<WebNews> webNews = new ArrayList<>();
        Page<WebNews> datas =  webNewsRepository.findAllByType(type,
                PageableTools.basicPage(page,size, new SortDto("time")));

        if (datas == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        for(WebNews u : datas) {
            webNews.add(u);
        }

        return new ResponseEntity<>(ResultModel.ok(webNews), HttpStatus.OK);
    }

    @RequestMapping(value = "updateNews", method = RequestMethod.POST)
    @ApiOperation(value="更新新闻")
    public ResponseEntity<ResultModel> updateNews(@RequestParam int id, @RequestParam String title, @RequestParam String content) {

        webNewsRepository.updateNews(content,title,id);

        return new ResponseEntity<>(ResultModel.ok("Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "addNews", method = RequestMethod.POST)
    @ApiOperation(value="添加新闻")
    public ResponseEntity<ResultModel> addNews(@RequestParam String name, @RequestParam String title, @RequestParam String info,
                                               @RequestParam String type,@RequestParam int top, @RequestParam int yn) {

        WebNews webNews = webNewsRepository.save(new WebNews(name, title, info, new Date(), type, top,yn));

        List<WebNews> retList = new ArrayList<>();
        retList.add(webNews);

        return new ResponseEntity<>(ResultModel.ok(retList), HttpStatus.OK);
    }

    @RequestMapping(value = "delNews", method = RequestMethod.POST)
    @ApiOperation(value="删除新闻")
    public ResponseEntity<ResultModel> delNews(@RequestParam Integer id) {
        webNewsRepository.delete(id);

        return new ResponseEntity<>(ResultModel.ok("Success"), HttpStatus.OK);
    }

    @GetMapping(value = "findAppvers")
    @ApiOperation(value="获取版本号")
    public ResponseEntity<ResultModel> findAppVers()  {

        List<AppVers>  appVers = appVersRepository.findAll();

        if (appVers == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(appVers), HttpStatus.OK);
    }
}
