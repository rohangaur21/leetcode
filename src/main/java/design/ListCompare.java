package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCompare {
    List<CompareWalletOptionType> list1 = Arrays.asList(
            new CompareWalletOptionType(WalletOptionType.MOTOROLA),
            new CompareWalletOptionType(WalletOptionType.SAMSUNG)
    );
    List<CompareWalletOptionType> list2 = Arrays.asList(
            new CompareWalletOptionType(WalletOptionType.ANDROID),
            new CompareWalletOptionType(WalletOptionType.APPLE),
            new CompareWalletOptionType(WalletOptionType.MOTOROLA)
    );

    public List<CompareWalletOptionType> getList1() {
        return list1;
    }

    public void setList1(List<CompareWalletOptionType> list1) {
        this.list1 = list1;
    }

    public List<CompareWalletOptionType> getList2() {
        return list2;
    }

    public void setList2(List<CompareWalletOptionType> list2) {
        this.list2 = list2;
    }

    public static void main(String[] args) {
        ListCompare lc = new ListCompare();
//        // If any number from List is present in List 2
//        System.out.println(
//                "If any number from aList is present in List 2 :" +
//                        list1.stream().anyMatch(num -> list2.contains(num)));
//        // If any number from List is present in List 2
//        System.out.println(
//                "If any number from aList is not present in List 2 :" +
//                        list1.stream().noneMatch(num -> list2.contains(num)));
//        // If any number from List is present in List 2
//        System.out.println(
//                "If all numbers from aList are present in List 2 :" +
//                        list1.stream().allMatch(num -> list2.contains(num)));
//
//        Predicate<design.CompareWalletOptionType> notIn2 = s -> ! list2.stream().allMatch(mc -> s.equals(mc.getWalletOptionType()));
//        List<design.CompareWalletOptionType> list3 = list1.stream().filter(notIn2).collect(Collectors.toList());
//
//
//        List<design.CompareWalletOptionType> l3 =list1.stream().filter(x -> list2.contains(x)).collect(Collectors.toList());

        List<CompareWalletOptionType> l4 = new ArrayList<>();
        lc.getList1().forEach(p ->
                lc.getList2().stream()
                        .filter(p1 -> p.getWalletOptionType().equals(p1.getWalletOptionType()))
                        .forEach(l4::add));

        for (CompareWalletOptionType l : l4) {
            System.out.println(l.getWalletOptionType().getValue());
        }

    }
}

class CompareWalletOptionType {
    private WalletOptionType walletOptionType;

    CompareWalletOptionType(WalletOptionType walletOptionType) {
        this.walletOptionType = walletOptionType;
    }

    public WalletOptionType getWalletOptionType() {
        return walletOptionType;
    }

    public void setWalletOptionType(WalletOptionType walletOptionType) {
        this.walletOptionType = walletOptionType;
    }
}

enum WalletOptionType {

    ANDROID(1L, "ANDROID"),
    APPLE(2L, "APPLE"),
    SAMSUNG(3L, "SAMSUNG"),
    MOTOROLA(4L, "MOTOROLA");

    private final Long id;
    private String value;

    WalletOptionType(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return this.id;
    }

    public String getValue() {
        return value;
    }

    public static WalletOptionType valueOf(Long id) {
        for (WalletOptionType t : WalletOptionType.values()) {
            if (t.getId().equals(id)) {
                return t;
            }
        }

        return null;
    }

    public static WalletOptionType findByValue(String value) {
        for (WalletOptionType t : WalletOptionType.values()) {
            if (t.getValue().equals(value)) {
                return t;
            }
        }

        return null;
    }

    public boolean equals(WalletOptionType t) {
        return t.id.equals(this.id);
    }

}
