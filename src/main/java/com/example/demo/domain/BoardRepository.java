package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    private static final BoardRepository boardrepository = new BoardRepository();

    public static BoardRepository getInstance() {
        return boardrepository;
    }

    private static Map<Long, Board> store = new HashMap<>();
    private Long sequence = 0L;

    public Board save(Board board) {
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    public Board put() {
        return null;
    }

    public Board delete() {
        return null;
    }

    public Board findById(Long BoardId){
        return store.get(BoardId);
    }

    public void clearAll(){
        store.clear();
    }

}
