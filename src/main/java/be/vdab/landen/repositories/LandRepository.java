package be.vdab.landen.repositories;

import be.vdab.landen.domain.Land;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandRepository extends JpaRepository<Land, String> {
}
