package sk.th.word;

import sk.th.pipifax.LanguagCode;
import sk.th.pipifax.entity.WordDbEntity;
import sk.th.pipifax.entity.WordEntity;

import java.util.List;

public interface WordDbService {

    List<WordDbEntity> findAllWords(LanguagCode currentLanguage);
}