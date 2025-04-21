package org.example.Model.Interfaces;

import java.util.List;

public interface I_Dao <T>{
     void insert (T t);
     List<T> list ();
     void delete (int id);
}
