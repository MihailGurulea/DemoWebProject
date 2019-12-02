package com.example.imacovei.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashcodeEquals {
	
	public static void main(String args[]) {
		Team t1 = new Team("c1", "d1");
		Team t2 = new Team("c2", "d2");
		Team t3 = new Team("c1", "d1");
		System.out.println(t1.equals(t3));
		Map<Team, String> leaders = new HashMap<>();
		leaders.put(new Team("New York", "development"), "Anne");
		leaders.put(new Team("Boston", "development"), "Brian");
		leaders.put(new Team("Boston", "marketing"), "Charlie");
		Set<Team> teamHashSet = new HashSet<>();
		teamHashSet.add(new Team("New York", "development"));
		
		Team myTeam = new Team("New York", "development");
		SportTeam mySportTeam = new SportTeam("New York", "development", "Delta");
		System.out.println(myTeam.equals(mySportTeam));
		teamHashSet.add(myTeam);
		teamHashSet.add(new Team("Boston", "development"));
		for (Team team : teamHashSet) {
			System.out.println(team);
		}
		String myTeamLeader = leaders.get(myTeam);
		System.out.println("myTeamLeader = " + myTeamLeader);
	}
	
	public static class Team {
		
		String city;
		String department;
		
		
		public Team(String city, String department) {
			this.city = city;
			this.department = department;
		}
		
		@Override
		public  boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof Team))
				return false;
			Team other = (Team) o;
			boolean cityCodeEquals = (this.city == null && other.city == null)
					|| (this.city != null && this.city.equals(other.city));
			boolean departmentCodeEquals = (this.department == null && other.department == null)
					|| (this.department != null && this.department.equals(other.department));
			return cityCodeEquals && departmentCodeEquals;
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			if (city != null) {
				result = 31 * result + city.hashCode();
			}
			if (department != null) {
				result = 31 * result + department.hashCode();
			}
			return result;
		}
		
		@Override
		public String toString() {
			return "Team{" + "city='" + city + '\'' + ", department='" + department + '\'' + '}';
		}
	}
	
	public static class SportTeam extends Team {
		
		private String name;
		
		public SportTeam(String city, String department, String name) {
			super(city, department);
			this.name = name;
			
		}
		
		public boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof SportTeam))
				return false;
			SportTeam other = (SportTeam) o;
			boolean cityCodeEquals = (this.city == null && other.city == null)
					|| (this.city != null && this.city.equals(other.city));
			boolean departmentCodeEquals = (this.department == null && other.department == null)
					|| (this.department != null && this.department.equals(other.department));
			
			boolean nameCodeEquals = (this.name == null && other.name == null)
					|| (this.name != null && this.name.equals(other.name));
			return cityCodeEquals && departmentCodeEquals && nameCodeEquals;
		}
	}
	
	
}

