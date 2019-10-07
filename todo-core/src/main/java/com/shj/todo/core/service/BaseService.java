package com.shj.todo.core.service;

import com.shj.todo.core.entity.BaseEntity;
import com.shj.todo.core.repostory.BaseRepository;
import com.shj.todo.core.utils.UUIDUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    BaseRepository<T> repository();

    default T create(T entity) {
        if (StringUtils.isBlank(entity.getId())) {
            entity.setId(UUIDUtils.generateUUID());
        }
        return this.repository().save(entity);
    }

    default T update(T entity) {
        return this.repository().save(entity);
    }

    default T getEntityById(String id) {
        return this.repository().getOne(id);
    }

    default List<T> listAll() {
        return this.repository().findAll();
    }

    default void delete(String id) {
        this.repository().deleteById(id);
    }

}
