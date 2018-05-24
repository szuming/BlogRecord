package cn.szu.ming.controller;

import cn.szu.ming.entity.Record;
import cn.szu.ming.service.RecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RecordController {
    private static Logger logger = Logger.getLogger(RecordController.class.getName());
    @Autowired
    RecordService recordService;

    @PostMapping("/addRecord")
    public ModelAndView addRecord(HttpServletRequest request, Record record,ModelAndView model){
        logger.debug(record);
        recordService.insertRecord(record);
        model.setViewName("test");
        return model;
    }

    @GetMapping("/showRecords")
    public ModelAndView getRecords(ModelAndView model,@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,@RequestParam(value = "pageSize",defaultValue = "80")int pageSize){
        List<Record> list=recordService.getRecords(pageNum,pageSize);
        model.addObject("list",list);
        model.setViewName("showRecords");
        return model;
    }
}
