package sk.th.word;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sk.th.pipifax.LanguagCode;
import sk.th.pipifax.entity.WordDbEntity;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-repositoryContext.xml")
public class WordDbRepositoryImplTest {

    @Autowired
    WordDbRepository wordRepository;

    @Test
    public void testFindAll() throws Exception {
        List<WordDbEntity> words = wordRepository.findAll("katka", LanguagCode.DE);
        Assert.assertNotNull(words);
        Assert.assertEquals(2, words.size());
    }
}
