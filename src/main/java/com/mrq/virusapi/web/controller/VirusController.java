package com.mrq.virusapi.web.controller;

import com.mrq.virusapi.services.VirusService;
import com.mrq.virusapi.web.model.RootModel;
import com.mrq.virusapi.web.model.Virus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/viruses")
@RequiredArgsConstructor
public class VirusController {

    private final VirusService virusService;

    @GetMapping
    public ListVirusResponse list(@RequestParam(required = false) String familyName,
                                  @RequestParam(defaultValue = "0") int pageNum,
                                  @RequestParam(defaultValue = "10") int pageSize) {
        final ListVirusResponse resp = new ListVirusResponse();
        final Page<Virus> virusPage = virusService.list(familyName, pageNum, pageSize);
        resp.setData(virusPage.getContent());
        resp.setPageNum(virusPage.getPageable().getPageNumber());
        resp.setPageSize(virusPage.getPageable().getPageSize());
        resp.setNumberOfElements(virusPage.getNumberOfElements());
        resp.setTotalElements(virusPage.getTotalElements());
        resp.setTotalPages(virusPage.getTotalPages());
        return resp;
    }

    @GetMapping(path = "/{id}")
    public VirusRequestResponse findById(@PathVariable BigInteger id) {
        final VirusRequestResponse resp = new VirusRequestResponse();
        resp.setData(virusService.findById(id));
        return resp;
    }

    @DeleteMapping(path = "/{id}")
    public VirusRequestResponse deleteById(@PathVariable BigInteger id) {
        final VirusRequestResponse resp = new VirusRequestResponse();
        resp.setData(virusService.deleteById(id));
        return resp;
    }


    @PatchMapping
    public VirusRequestResponse update(@RequestBody VirusRequestResponse request) {
        final VirusRequestResponse resp = new VirusRequestResponse();
        resp.setData(virusService.save(request.getData()));
        return resp;
    }


}

@Getter
@Setter
class ListVirusResponse extends RootModel<List<Virus>> {
    Integer pageSize;
    Integer pageNum;
    Integer numberOfElements;
    Long totalElements;
    Integer totalPages;
}

@Getter
@Setter
class VirusRequestResponse extends RootModel<Virus> {

}