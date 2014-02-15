package sk.th.word;

import org.springframework.stereotype.Repository;
import sk.th.pipifax.LanguagCode;
import sk.th.pipifax.entity.WordDbEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class WordDbRepositoryImpl implements WordDbRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<WordDbEntity> findAll(LanguagCode currentLanguage) {
        Query query = entityManager.createQuery("select w from WordDbEntity w left join w.language l where l.code = :lang ");
        query.setParameter("lang", currentLanguage);
        return query.getResultList();
    }
}