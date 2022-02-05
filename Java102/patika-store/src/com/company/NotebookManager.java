package com.company;

import java.util.List;

public class NotebookManager implements ProductService<Notebook>{

    public NotebookManager() {

    }

    @Override
    public boolean create(Notebook entity) {
        return InMemoryDB.notebooks.add(entity);
    }

    @Override
    public List<Notebook> getAll() {
        return InMemoryDB.notebooks;
    }

    @Override
    public Notebook getById(int id) {
        Notebook notebook = null;
        for (Notebook x :
                InMemoryDB.notebooks) {
            if (x.getId() == id) {
                notebook = x;
                break;
            }
        }
        return notebook;
    }

    @Override
    public boolean delete(int id) {
        var notebook = getById(id);
        return InMemoryDB.notebooks.remove(notebook);
    }
}
