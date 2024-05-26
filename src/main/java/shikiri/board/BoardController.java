package shikiri.board;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "shikiri-board")
public interface BoardController {

    @PostMapping("/boards")
    ResponseEntity<BoardOut> create (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) BoardIn in
    );

    @PutMapping("/boards")
    ResponseEntity<BoardOut> update (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) BoardIn in
    );

    @DeleteMapping("/boards")
    ResponseEntity<BoardOut> delete (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) String id
    );

    @GetMapping("/boards")
    ResponseEntity<BoardOut> getBoardById (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestBody(required = true) String id
    );

    @GetMapping("/boards/search/by-name")
    ResponseEntity<List<BoardOut>> findBoardsByNameContaining (
        @RequestHeader(required = true, name = "Authorization") String key,
        @RequestParam(required = true) String name,
        @RequestParam(defaultValue = "name") String sortBy
    );

    @GetMapping("/boards")
    ResponseEntity<List<BoardOut>> findOrderByName (
        @RequestHeader(required = true, name = "Authorization") String key
    );
}