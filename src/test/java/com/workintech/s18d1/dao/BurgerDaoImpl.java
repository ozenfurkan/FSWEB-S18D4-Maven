package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public class BurgerDaoImpl implements BurgerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Override
    public Burger remove(long id) {
        Burger burger = findById(id);
        if (burger != null) {
            entityManager.remove(burger);
        }
        return burger;
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.contents LIKE :contents", Burger.class)
                .setParameter("contents", "%" + content + "%");
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType", Burger.class)
                .setParameter("breadType", breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.price = :price", Burger.class)
                .setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(long id) {
        return entityManager.find(Burger.class, id);
    }
}
