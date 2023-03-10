package com.example.demo.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardRepositoryTest {

    BoardRepository boardRepository = BoardRepository.getInstance();

    @AfterEach
    void afterEach() {
        boardRepository.clearAll();
    }

    @Test
    void save() {
        //given
        Board board1 = new Board(12205179, "공준우",
                "공준우입니다", "안녕하세요 첫 글입니다.");

        //when
        Board savedBoard1 = boardRepository.save(board1);

        //then
        Board findBoard = boardRepository.findById(savedBoard1.getId());
        assertThat(findBoard).isEqualTo(savedBoard1);
    }

    @Test
    void findAll() {
        //given
        Board board1 = new Board(12205179, "공준우",
                "공준우입니다", "안녕하세요 첫 글입니다.");

        Board board2 = new Board(12205046, "박성훈",
                "박성훈입니다", "안녕하세요 첫 글입니다.");

        boardRepository.save(board1);
        boardRepository.save(board2);

        //when
        List<Board> boards = boardRepository.findAll();

        //then
        assertThat(boards.size()).isEqualTo(2);
        assertThat(boards).contains(board1, board2);
    }

    @Test
    void put() {
    }

    @Test
    void delete() {
    }
}