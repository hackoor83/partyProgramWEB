package com.partyProgram.partyProgram;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Person, Long> {
}
