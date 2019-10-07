package app.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import app.entitiy.Zip;

public class ZipService {
    private List<Zip> zips;

    public ZipService(List<Zip> zips) {
        this.zips = zips;
    }

    public Zip zipById(String id) {
        for (Zip zip : zips) {
            if (Objects.equals(zip.getId(), Long.valueOf(id))) {
                return zip;
            }
        }
        return null;
    }

    public Zip createZip(Zip zip) {
        zip.setId(zips.stream().map(Zip::getId).max(Comparator.naturalOrder()).orElse(0L) + 1);
        zips.add(zip);
        return zip;
    }
}
