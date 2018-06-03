package cn.szu.ming.controller;

import cn.szu.ming.entity.Record;
import cn.szu.ming.entity.Tag;
import cn.szu.ming.service.RecordService;
import cn.szu.ming.service.TagService;
import cn.szu.ming.service.redis.ListService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class RecordController {
    private static Logger logger = Logger.getLogger(RecordController.class.getName());
    @Autowired
    RecordService recordService;
    @Autowired
    TagService tagService;
    @Autowired
    ListService listService;            //redis缓存记录链表


    /**
     * 接受Google插件post过来的Record
     * @param request
     * @param record
     * @param model
     * @return
     */
    @PostMapping("/addRecord")
    public ModelAndView addRecord(HttpServletRequest request, Record record,ModelAndView model) throws IOException {
        logger.debug(record);
        //往mysql加入record
        recordService.insertRecord(record);
        //往redis更新record的list
        //从mysql中获取刚刚插入的record
        record=recordService.selectLast();
        listService.leftAddRecord("RecordList:1",record);
        model.setViewName("test");
        return model;
    }

    @PostMapping("/showRecords")
    public ModelAndView tagShowRecords(ModelAndView model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,@RequestParam(value = "pageSize",defaultValue = "80")int pageSize){
        return model;
    }

    /**
     * 展示记录
     * @param model
     * @param pageNum       第几页
     * @param pageSize      一页的记录数量
     * @return
     */
    @GetMapping("/showRecords")
    public ModelAndView getRecords(ModelAndView model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,@RequestParam(value = "pageSize",defaultValue = "80")int pageSize) throws IOException {
        //查询所有标签
        List<Tag> tagList=tagService.getTags();
        //查询记录
        List<Record> list;
        //如果有缓存，直接返回缓存
        if((list=listService.getRecordList("RecordList:"+pageNum))!=null){     //key的格式--> Record:1:1
        }else{      //redis没有该缓存，则到mysql中查询
            list=recordService.getRecords(pageNum,pageSize);
            //查询得到后的list更新到redis中去
            listService.addList("RecordList:"+pageNum,list);
        }
        model.addObject("tagList",tagList);
        model.addObject("list",list);
        model.setViewName("showRecords");
        return model;
    }
}
