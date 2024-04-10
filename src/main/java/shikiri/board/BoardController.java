package shikiri.board;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "shikiri-board")
public interface BoardController {

    @PostMapping("/boards/create")
    ResponseEntity<BoardOut> create (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) BoardIn in
    );

    @PutMapping("/boards/{id}")
    ResponseEntity<BoardOut> update (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) BoardIn in
    );

    @DeleteMapping("/boards/{id}")
    ResponseEntity<BoardOut> delete (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) String id
    );

    @GetMapping("/boards/{id}")
    ResponseEntity<BoardOut> getBoardById (
        @RequestHeader(required = true, name = "Authorization") String key,
        @PathVariable(required = true) String id
    );

    @GetMapping("/boards/search/by-name")
    ResponseEntity<List<BoardOut>> findBoardsByNameContaining (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestParam(required = true) String name,
        @RequestParam(defaultValue = "name") String sortBy
    );

    @GetMapping("/boards/all/sorted-by-date")
    ResponseEntity<List<BoardOut>> findAllBoardsOrderedByCreationDateDesc (
        @RequestHeader(required = true, name = "Authorization") String key
    );
}