package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloHJPATest");;
//
//            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            // 영속
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            // 영속
//            Member member1 = new Member(101L, "Hello");
//            Member member2 = new Member(102L, "World");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("=== AFTER ===");

//            Member member = new Member(200L, "Hello");
//            em.persist(member);
//
//            // 강제 호출
//            em.flush();

            Member member = em.find(Member.class, 200L);
            member.setName("World");

            em.detach(member);

            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
