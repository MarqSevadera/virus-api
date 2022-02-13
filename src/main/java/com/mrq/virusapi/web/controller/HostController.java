package com.mrq.virusapi.web.controller;

import com.mrq.virusapi.services.HostService;
import com.mrq.virusapi.web.model.Host;
import com.mrq.virusapi.web.model.RootModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hosts")
@RequiredArgsConstructor
public class HostController {

    private final HostService hostService;


    @GetMapping
    public ListHostResponse list(@RequestParam(defaultValue = "0") int pageNum,
                                  @RequestParam(defaultValue = "10") int pageSize) {
        final ListHostResponse resp = new ListHostResponse();
        final Page<Host> hostaPge = hostService.list(pageNum, pageSize);
        resp.setData(hostaPge.getContent());
        resp.setPageNum(hostaPge.getPageable().getPageNumber());
        resp.setPageSize(hostaPge.getPageable().getPageSize());
        resp.setNumberOfElements(hostaPge.getNumberOfElements());
        resp.setTotalElements(hostaPge.getTotalElements());
        resp.setTotalPages(hostaPge.getTotalPages());
        return resp;
    }

    @GetMapping(path = "/{id}")
    public HostRequestResponse findById(@PathVariable BigInteger id) {
        final HostRequestResponse resp = new HostRequestResponse();
        resp.setData(hostService.findById(id));
        return resp;
    }

    @DeleteMapping(path = "/{id}")
    public HostRequestResponse deleteById(@PathVariable BigInteger id) {
        final HostRequestResponse resp = new HostRequestResponse();
        resp.setData(hostService.deleteById(id));
        return resp;
    }


    @PatchMapping
    public HostRequestResponse update(@RequestBody HostRequestResponse request) {
        final HostRequestResponse resp = new HostRequestResponse();
        resp.setData(hostService.save(request.getData()));
        return resp;
    }


}

@Getter
@Setter
class ListHostResponse extends RootModel<List<Host>> {
    Integer pageSize;
    Integer pageNum;
    Integer numberOfElements;
    Long totalElements;
    Integer totalPages;
}

@Getter
@Setter
class HostRequestResponse extends RootModel<Host> {

}