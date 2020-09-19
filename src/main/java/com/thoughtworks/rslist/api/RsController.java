package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.dto.RsEvent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RsController {
  private List<RsEvent> rsList = initRsList();

  private List<RsEvent> initRsList() {
    List<RsEvent> tempRsList = new ArrayList<>();
    tempRsList.add(new RsEvent("第一条事件", "无分类"));
    tempRsList.add(new RsEvent("第二条事件","无分类"));
    tempRsList.add(new RsEvent("第三条事件","无分类"));
    return tempRsList;
  }

  @GetMapping("/rs/list")
  public List<RsEvent> getAllRsEvent(@RequestParam(required = false) Integer start,
                                     @RequestParam(required = false) Integer end) {
    if(start == null || end == null) {
      return rsList;
    }
    return rsList.subList(start - 1, end);
  }

  @GetMapping("/rs/{index}")
  //@PathVariable 表明了这个index是要加到path里的
  public RsEvent getRsEvent(@PathVariable int index) {
    return rsList.get(index - 1);
  }

  @PostMapping("/rs/event")
  //@RequestBody 表明了要来这里拿这个body
  public void addRsEvent(@RequestBody RsEvent rsEvent) {
    rsList.add(rsEvent);
  }

  @PutMapping("/rs/{index}")
  public void updateRsEvent(@PathVariable int index, @RequestBody RsEvent rsEvent) {
    rsList.set(index - 1, rsEvent);
  }
}
