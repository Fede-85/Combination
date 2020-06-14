package com.combination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Ennupla<T> implements Cloneable{

    List<T> elements;

    public void add(T element) {
        elements.add(element);
    }

    @Override
    public Ennupla<T> clone() throws CloneNotSupportedException {
        Ennupla<T> ennupla = (Ennupla<T>) super.clone();
        ennupla.setElements(this.elements.stream().collect(Collectors.toList()));
        return ennupla;
    }

    public void removeLast(){
        this.elements.remove(this.elements.size()-1);
    }

    /**
     * 
     * @param ennupla - Ennupla to mantain temporary values
     * @param values - Initial values array
     * @param ennuple - List of ennuple produced
     * @param n - ennupla size
     * @param tmpIndex - temporary index
     * @param <T> - Generic ennupla's type
     * @throws CloneNotSupportedException
     */
    public static <T> void calculateEnnuple(
            Ennupla<T> ennupla,
            List<T> values,
            List<Ennupla<T>> ennuple,
            int n,
            int tmpIndex) throws CloneNotSupportedException {

        if (n == 0) {
            ennuple.add(ennupla);
            return;
        }

        for (int i = tmpIndex; i <= values.size() - n; i++) {
            ennupla.add(values.get(i));
            calculateEnnuple(ennupla.clone(), values, ennuple, n-1, i+1);
            ennupla.removeLast();
        }
    }
}
