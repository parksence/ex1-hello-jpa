package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("Jack");
            member.setHomeAddress(new Address("homeCity", "street", "100"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddresseHistory().add(new AddressEntity("old1", "street", "100"));
            member.getAddresseHistory().add(new AddressEntity("old2", "street", "100"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============== START ================");
            // 값 타입 조회
            Member findMember = em.find(Member.class, member.getId());

            // 값 수정 예제 (homeCity -> newCity)
//            Address homeAddress = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", homeAddress.getStreet(), homeAddress.getZipcode()));

            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

            // 주소 변경
//            findMember.getAddresseHistory().remove(new Address("old1", "street", "100"));
//            findMember.getAddresseHistory().add(new Address("newCity1", "street", "100"));

            System.out.println("============== END ==================");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
