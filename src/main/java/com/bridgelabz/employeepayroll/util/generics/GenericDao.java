package com.bridgelabz.employeepayroll.util.generics;

import java.util.List;

/**
 * @desc : Generic Dao Interface
 * @param : <T>
 */
public interface GenericDao <T>{
    /**
     * @desc : Method to insert the new entity
     * @param : entity
     */
    void insert(T entity);

    /**
     * @desc : Method to update the entity
     * @param : entity
     */
    void update(T entity);

    /**
     * @desc : Method to delete the entity by id
     * @param : id
     */
    void deleteBy(int id);

    /**
     * @desc : Method to find entity by id
     * @param : id
     * @return : entity
     */
    T findById(int id);

    /**
     * @desc : Method to find all the entities
     * @return : list of all entities
     */
    List<T> findAll();
}
