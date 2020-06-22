package com.example.bulletinboard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BulletinBoardRepository extends JpaRepository<BulletinBoard, Long> {

    public BulletinBoard findById(int id);
    public void deleteById(int id);
}
