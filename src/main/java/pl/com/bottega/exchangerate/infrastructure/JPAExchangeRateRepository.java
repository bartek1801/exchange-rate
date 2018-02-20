package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.NoRateException;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class JPAExchangeRateRepository implements ExchangeRateRepository {

    private EntityManager entityManager;

    public JPAExchangeRateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(ExchangeRate exchangeRate) {
        entityManager.persist(exchangeRate);
    }

    @Override
    public List<ExchangeRate> find(String date, String currency) {
        Query query = entityManager.createQuery("SELECT er FROM ExchangeRate er " +
                "WHERE er.date = :date AND er.currency = :currency");
        query.setParameter("date", date);
        query.setParameter("currency", currency);
        return (List<ExchangeRate>) query.getResultList();
    }

}
