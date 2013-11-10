package sk.th.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sk.th.pipifax.entity.WordEntity;
import sk.th.pipifax.util.SecurityUtil;
import sk.th.word.sk.th.pipifax.web.SettingsModel;

import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class WordController {

    private final WordService wordService;

    private final WordModel wordModel;

    private final SettingsModel settingsModel;

    private String file;

    @Autowired
    public WordController(WordService wordService, WordModel wordModel, SettingsModel settingsModel) throws IOException {
        this.wordService = wordService;
        this.wordModel = wordModel;
        this.settingsModel = settingsModel;
    }

    public void initTemplate() {
        if (wordModel.getWordCount() == null) {
            String currentUserName = SecurityUtil.getCurrentUserName();
            List<WordEntity> allWords = wordService.findAllWords(currentUserName, settingsModel.getCurrentLanguage());
            wordModel.setWordCount(allWords.size());
        }
    }

    public void initWord() {
        String currentUserName = SecurityUtil.getCurrentUserName();
        //todo do not load
        List<WordEntity> allWords = wordService.findAllWords(currentUserName, settingsModel.getCurrentLanguage());
        wordModel.setWordCount(allWords.size());
        if (allWords.size() > 0) {
            Collections.shuffle(allWords);
            wordModel.setCurrentWord(allWords.get(0));
        }
    }

    public void dangerActionListener(ActionEvent e) {
        initWord();
    }

    public String getCurrentUser() {
        return SecurityUtil.getCurrentUserName();
    }
}
