package com.records.controller;

import com.records.model.Entity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Records")
public class RecordRestController
{

    private Map<Long, Entity> records=new HashMap<>();

    @GetMapping
    public List<?> displayAll()
    {
        return new ArrayList<>(records.values());
    }

    @GetMapping("id/{myId}")
    public Entity getBYId(@PathVariable Long myId)
    {
        return records.get(myId);
    }

    @PostMapping
    public boolean createEntity(@RequestBody Entity entry)
    {
        try
        {
            records.put(entry.getId(),entry);
            return true;
        }
        catch (Exception e)
        {
            System.err.println("Exception Occurred : "+e.getMessage());
            return false;
        }
    }
    @PutMapping("id/{myId}")
    public void updateEntryById(@PathVariable Long myId, @RequestBody Entity entry)
    {
        records.put(myId, entry);
    }

    @DeleteMapping("id/{myId}")
    public Entity removeEntityById(@PathVariable Long myId)
    {
        return records.remove(myId);
    }


}
