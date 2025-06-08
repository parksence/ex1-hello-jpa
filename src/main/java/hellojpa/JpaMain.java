package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("test1");
            em.persist(member);

            em.flush();
            em.clear();

            Member reference = em.getReference(Member.class, member.getId());
            System.out.println("reference.getClass() = " + reference.getClass()); // Proxy
            Hibernate.initialize(reference.getClass()); // 강제 초기화

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getName());
    }

    private static void printMemberAndTeam(Member member) {
        String name = member.getName();
        System.out.println("name = " + name);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
