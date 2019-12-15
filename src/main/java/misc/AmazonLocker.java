package misc;

import java.util.*;

public class AmazonLocker {
    enum LockerType {
        X_Small,
        Small,
        Medium,
        Large,
        X_Large;
    }

    enum LockerStatus {
        Empty,
        Fill;
    }

    class Locker {
        Integer id;
        LockerType type;
        LockerStatus status;
        Integer orderNumber;
        Integer lockerManagerId;
        // boolean EmptyLocker(Integer lockerId)
    }

    class LockerManager {
        Integer id;
        List lockers;
        String lockerAddress;
        // Locker GetSingleEmptyLockerBytype(LockerType type)
    }
    class LockerAllocation{
        Map<String, LockerManager> lockerManagerMap;
        // List<LockerManager> ShowMeLockers(String userAddress)
        // boolean FillLocker(Locker locker, Guid productCatalogId)
        // Hashtable<Locker, bool> GetLockersByManager(Integer managerId)
    }


}