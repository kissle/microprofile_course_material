package qs.mp.control;

import jakarta.enterprise.context.ApplicationScoped;
import qs.mp.entity.Skill;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SkillService {

        List<Skill> skills = new ArrayList<>();

        public List<Skill> getAll() {
            return skills;
        }

        public Skill getById(int id){
            return skills.stream().filter(skill -> skill.getId() == id).findFirst().orElse(null);
        }

        public void create(Skill skill) {
            skills.add(skill);
        }

        public Boolean isMoreExperiencedThan(Skill skill1, Skill skill2) {
            return skill1.isMoreExperiencedThan(skill2);
        }

        public List<Skill> getEmployees(int id) {
            return skills;
        }
}
