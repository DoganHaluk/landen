package be.vdab.landen.services;

import be.vdab.landen.repositories.LandRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultLandService implements LandService {
    private final LandRepository repository;

    public DefaultLandService(LandRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public long findAantal() {
        return repository.count();
    }
}
