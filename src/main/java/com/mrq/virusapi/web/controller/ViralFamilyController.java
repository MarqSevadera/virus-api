package com.mrq.virusapi.web.controller;

import com.mrq.virusapi.services.ViralFamilyService;
import com.mrq.virusapi.web.model.RootModel;
import com.mrq.virusapi.web.model.ViralFamily;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/viral-families")
@RequiredArgsConstructor
public class ViralFamilyController {

    private final ViralFamilyService viralFamilyService;

    @GetMapping
    public ListViralFamiliyResponse list(@RequestParam(defaultValue = "0") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize) {
        final ListViralFamiliyResponse resp = new ListViralFamiliyResponse();
        final Page<ViralFamily> viralPage = viralFamilyService.list(pageNum, pageSize);
        resp.setData(viralPage.getContent());
        resp.setPageNum(viralPage.getPageable().getPageNumber());
        resp.setPageSize(viralPage.getPageable().getPageSize());
        resp.setNumberOfElements(viralPage.getNumberOfElements());
        resp.setTotalElements(viralPage.getTotalElements());
        resp.setTotalPages(viralPage.getTotalPages());
        return resp;
    }

    @GetMapping(path = "/{id}")
    public ViralFamilyRequestResponse findById(@PathVariable BigInteger id) {
        final ViralFamilyRequestResponse resp = new ViralFamilyRequestResponse();
        resp.setData(viralFamilyService.findById(id));
        return resp;
    }

    @DeleteMapping(path = "/{id}")
    public ViralFamilyRequestResponse deleteById(@PathVariable BigInteger id) {
        final ViralFamilyRequestResponse resp = new ViralFamilyRequestResponse();
        resp.setData(viralFamilyService.deleteById(id));
        return resp;
    }


    @PatchMapping
    public ViralFamilyRequestResponse update(@RequestBody ViralFamilyRequestResponse request) {
        final ViralFamilyRequestResponse resp = new ViralFamilyRequestResponse();
        resp.setData(viralFamilyService.save(request.getData()));
        return resp;
    }
}


@Getter
@Setter
class ListViralFamiliyResponse extends RootModel<List<ViralFamily>> {
    Integer pageSize;
    Integer pageNum;
    Integer numberOfElements;
    Long totalElements;
    Integer totalPages;
}


@Getter
@Setter
class ViralFamilyRequestResponse extends RootModel<ViralFamily> {

}