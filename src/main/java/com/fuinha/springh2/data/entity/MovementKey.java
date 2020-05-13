package com.fuinha.springh2.data.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovementKey implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer month;
    private Integer year;
    private Integer number;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovementKey pk = (MovementKey) o;
        return Objects.equals(month, pk.month) && Objects.equals(year, pk.year) && Objects.equals(number, pk.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, year, number);
    }
}