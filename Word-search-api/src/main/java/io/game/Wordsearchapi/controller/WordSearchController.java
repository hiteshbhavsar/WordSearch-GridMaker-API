package io.game.Wordsearchapi.controller;

import io.game.Wordsearchapi.services.WordGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class WordSearchController {

    @Autowired
    WordGridService wordGridService;
    //@GetMapping("/wordgrid")
    @RequestMapping(method = RequestMethod.GET,path = "/wordgrid")
    public String createWordGrid(@RequestParam int GridSize,@RequestParam String wordList)
    {
        List<String> words= Arrays.asList(wordList.split(","));
        char[][] contents=wordGridService.GenerateGrid(GridSize,words);
        StringBuilder gridtoString=new StringBuilder("");

        for(int i=0;i<GridSize;i++)
        {
            for(int j=0;j<GridSize;j++)
            {
                gridtoString.append(contents[i][j]+" ");
            }
            gridtoString.append("\r\n");
        }

        return gridtoString.toString();
    }
}
