package mobile.mobileprogrm.board.controller;
import lombok.RequiredArgsConstructor;
import mobile.mobileprogrm.board.Dto.BoardDTO;
import mobile.mobileprogrm.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final BoardService boardService;

    @GetMapping
    public String home(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "list";
    }
}