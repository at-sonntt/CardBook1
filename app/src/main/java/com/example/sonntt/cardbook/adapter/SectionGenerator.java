package com.example.sonntt.cardbook.adapter;

import com.example.sonntt.cardbook.adapter.SectionedAdapter;
import com.example.sonntt.cardbook.until.Categorizable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sonntt on 12/18/15.
 */
class SectionGenerator {
    /**
     * Adds section header objects into a list of {@link Categorizable} data objects.  For each
     * unique category title returned by the list objects, a corresponding section header will be
     * inserted into the list.
     *
     * @param items a {@link List} of <code>Categorizable</code> objects
     * @return the original list of objects with {@link com.cardinalsolutions.sectioned_adapter.SectionedAdapter.SectionHeader}s inserted
     */
    static List<Object> getSectionsForItems(List<? extends Categorizable> items) {
        /* Creates a mapping of section headers to the position they should be inserted in the list */
        Map<Integer, String> sectionHeaders = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            String category = items.get(i).getCategory();
            if (!sectionHeaders.containsValue(category)) {
                sectionHeaders.put(i + sectionHeaders.size(), category);
            }
        }

        /* Merges the list of section headers into the appropriate position in the object list */
        ArrayList<Object> listItems = new ArrayList<>();
        int sectionCount = 0;
        for (int i = 0; i < items.size() + sectionHeaders.size(); i++) {
            if (sectionHeaders.containsKey(i)) {
                listItems.add(new SectionedAdapter.SectionHeader(sectionHeaders.get(i)));
                sectionCount++;
            } else {
                listItems.add(items.get(i - sectionCount));
            }
        }
        return listItems;
    }
}