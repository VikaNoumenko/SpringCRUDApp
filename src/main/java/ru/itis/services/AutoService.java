package ru.itis.services;

import ru.itis.models.Auto;

import java.util.List;

/**
 * 11.10.2017
 * AutoService
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

public interface AutoService {
    void addAuto(Auto auto);
    List<Auto> getAllAuto();
}
