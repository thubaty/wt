package sk.th.word;

import sk.th.pipifax.LanguagCode;
import sk.th.pipifax.entity.WordDbEntity;

import java.util.List;

public interface LanguageService {

    List<LanguagCode> getAllLanguages();
}