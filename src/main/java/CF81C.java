import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CF81C {
	
	private static class Thing{
		String name;
		String className;
		int atk;
		int def;
		int res;
		int size;
		public Thing(String name,String className,int atk,int def,int res,int size){
			this.name = name;
			this.className = className;
			this.atk = atk;
			this.def = def;
			this.res = res;
			this.size = size;
		}
		
		public boolean equals(Object o){
			if(o!=null && o instanceof Thing){
				Thing th = (Thing)o;
				return name.equals(th.name);
			}
			return false;
		}
		public int hashCode(){
			return name.hashCode();
		}
	}
	
	private static class Resident{
		String name;
		String type;
		String home;
		int bonus;
		public Resident(String name,String type,int bonus,String home){
			this.name = name;
			this.type = type;
			this.home = home;
			this.bonus = bonus;
		}
		public boolean equals (Object o){
			if(o != null && o instanceof Resident){
				Resident res = (Resident)o;
				return name.equals(res.name);
			}
			return false;
		}
		public int hashCode(){
			return name.hashCode();
		}
	}
	
	private static final String RES_ATK = "gladiator";
	private static final String RES_DEF = "sentry";
	private static final String RES_RES = "physician";
	private static final String THG_WEAPON = "weapon";
	private static final String THG_ARMOR = "armor";
	private static final String THG_ORB = "orb";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Thing> weapons = new ArrayList<Thing>();
		ArrayList<Thing> armors = new ArrayList<Thing>();
		ArrayList<Thing> orbs = new ArrayList<Thing>();
		String[]parts = null;
		int places = 0;
		for(int i = 0; i < n; i++){
			parts = br.readLine().split("\\s+");
			Thing thing = new Thing(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
			if(thing.className.equals(THG_WEAPON)){
				weapons.add(thing);
			}
			else if(thing.className.equals(THG_ARMOR)){
				armors.add(thing);
			}
			else{
				orbs.add(thing);
			}
			places += thing.size;
		}
		int k = Integer.parseInt(br.readLine());		
		HashMap<String, Resident> residentsMap = new HashMap<String, Resident>();
		ArrayList<String> ordAtk = new ArrayList<String>();
		ArrayList<String> ordDef = new ArrayList<String>();
		ArrayList<String> ordRes = new ArrayList<String>();
		HashMap<String, ArrayList<String>> initialResidentsInThing = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < k; i++){
			parts = br.readLine().split("\\s+");
			Resident resident = new Resident(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
			residentsMap.put(resident.name, resident);
			
			ArrayList<String> list = initialResidentsInThing.get(resident.home);
			if(list==null){
				list = new ArrayList<String>();
			}
			list.add(resident.name);
			initialResidentsInThing.put(resident.home,list);
			
			ArrayList<String> myList = null;
			if(resident.type.equals(RES_ATK)){
				myList = ordAtk;
			}
			else if(resident.type.equals(RES_DEF)){
				myList = ordDef;				
			}
			else {
				myList = ordRes;
			}
			boolean isIns = false;
			int cnt = 0;
			for(String resName : myList){
				Resident concurrent = residentsMap.get(resName);
				if(concurrent.bonus<resident.bonus){
					myList.add(cnt,resident.name);
					isIns = true;
					break;
				}
				cnt++;
			}
			if(!isIns){
				myList.add(resident.name);
			}
		}
		//not possible to move
		if(places==k){
			StringBuffer sb = new StringBuffer();

			int maxWeapon = Integer.MIN_VALUE; 
			String weaponName = null;
			for(Thing weapon : weapons){
				int rating = weapon.atk;
				for(String resName : ordAtk){
					Resident res = residentsMap.get(resName);
					if(res.home.equals(weapon.name)){
						rating += res.bonus;
					}
				}
				if(maxWeapon<rating){
					maxWeapon = rating;
					weaponName = weapon.name;
				}
			}
			sb = new StringBuffer();
			for(String resName : initialResidentsInThing.get(weaponName)){
				sb.append(" " + resName);
			}
			System.out.println(weaponName + " " + initialResidentsInThing.get(weaponName).size() + sb.toString());			

			int maxArmor = Integer.MIN_VALUE; 
			String armorName = null;
			for(Thing armor : armors){
				int rating = armor.def;
				for(String resName : ordDef){
					Resident res = residentsMap.get(resName);
					if(res.home.equals(armor.name)){
						rating += res.bonus;
					}
				}
				if(maxArmor<rating){
					maxArmor = rating;
					armorName = armor.name;
				}
			}
			sb = new StringBuffer();
			for(String resName : initialResidentsInThing.get(armorName)){
				sb.append(" " + resName);
			}
			System.out.println(armorName + " " + initialResidentsInThing.get(armorName).size() + sb.toString());
			
			int maxOrb = Integer.MIN_VALUE; 
			String orbName = null;
			for(Thing orb : orbs){
				int rating = orb.res;
				for(String resName : ordRes){
					Resident res = residentsMap.get(resName);
					if(res.home.equals(orb.name)){
						rating += res.bonus;
					}
				}
				if(maxOrb<rating){
					maxOrb = rating;
					orbName = orb.name;
				}
			}
			sb = new StringBuffer();
			for(String resName : initialResidentsInThing.get(orbName)){
				sb.append(" " + resName);
			}
			System.out.println(orbName + " " + initialResidentsInThing.get(orbName).size() + sb.toString());
			
		}
		else{
			int count = 0;
			
			Set<String> occupiedResidents = new HashSet<String>();
			
			int maxAtk = Integer.MIN_VALUE;
			HashMap<Integer, ArrayList<Thing>> weaponsByAtk = new HashMap<Integer, ArrayList<Thing>>();
			for(Thing thing : weapons){
				int currAtk = thing.atk;
				count = 0;
				for(String resName : ordAtk){
					if(count++>=thing.size)break;
					Resident res = residentsMap.get(resName);
					currAtk += res.bonus;
				}
				if(currAtk>maxAtk)maxAtk = currAtk;
				ArrayList<Thing> arrayThings = weaponsByAtk.get(currAtk);
				if(arrayThings==null){
					arrayThings = new ArrayList<Thing>();
				}
				arrayThings.add(thing);
				weaponsByAtk.put(currAtk, arrayThings);
			}
			ArrayList<Thing> maxWeapons = weaponsByAtk.get(maxAtk);
			Thing maxWeapon = maxWeapons.get(0);
			int countResidentsForWeapon = 0;
			ArrayList<String> resultingResidentsForWeapon = new ArrayList<String>();
			for(String resName : ordAtk){
				if(countResidentsForWeapon+1>maxWeapon.size)break;
				++countResidentsForWeapon;
				Resident res = residentsMap.get(resName);
				resultingResidentsForWeapon.add(res.name);
				occupiedResidents.add(res.name);
			}
			//System.out.println(maxWeapon.name + " " + count + resultingResidentsForWeapon.toString());
			
			int maxDef = Integer.MIN_VALUE;
			HashMap<Integer, ArrayList<Thing>> armorsByDef = new HashMap<Integer, ArrayList<Thing>>();
			for(Thing thing : armors){
				int currDef= thing.def;
				count = 0;
				for(String resName : ordDef){
					if(count++>=thing.size)break;
					Resident res = residentsMap.get(resName);
					currDef += res.bonus;
				}
				if(currDef>maxDef)maxDef = currDef;
				ArrayList<Thing> arrayThings = armorsByDef.get(currDef);
				if(arrayThings==null){
					arrayThings = new ArrayList<Thing>();
				}
				arrayThings.add(thing);
				armorsByDef.put(currDef, arrayThings);
			}
			ArrayList<Thing> maxArmors = armorsByDef.get(maxDef);
			Thing maxArmor = maxArmors.get(0);
			int countResidentsForArmor = 0;
			ArrayList<String> resultingResidentsForArmor = new ArrayList<String>();
			for(String resName : ordDef){
				if(countResidentsForArmor+1>maxArmor.size)break;
				++countResidentsForArmor;
				Resident res = residentsMap.get(resName);
				resultingResidentsForArmor.add(res.name);
				occupiedResidents.add(res.name);
			}
			//System.out.println(maxArmor.name + " " + count + resultingResidentsForArmor.toString());
			
			int maxRes = Integer.MIN_VALUE;
			HashMap<Integer, ArrayList<Thing>> ordByRes = new HashMap<Integer, ArrayList<Thing>>();
			for(Thing thing : orbs){
				int currRes= thing.res;
				count = 0;
				for(String resName : ordRes){
					if(count++>=thing.size)break;
					Resident res = residentsMap.get(resName);
					currRes += res.bonus;
				}
				if(currRes>maxRes)maxRes = currRes;
				ArrayList<Thing> arrayThings = ordByRes.get(currRes);
				if(arrayThings==null){
					arrayThings = new ArrayList<Thing>();
				}
				arrayThings.add(thing);
				ordByRes.put(currRes, arrayThings);
			}
			ArrayList<Thing> maxOrds = ordByRes.get(maxRes);
			Thing maxOrd = maxOrds.get(0);
			int countResidentsForOrd = 0;
			ArrayList<String> resultingResidentsForOrd = new ArrayList<String>();
			for(String resName : ordRes){
				if(countResidentsForOrd+1>maxOrd.size)break;
				++countResidentsForOrd;
				Resident res = residentsMap.get(resName);
				resultingResidentsForOrd.add(res.name);
				occupiedResidents.add(res.name);
			}
			//System.out.println(maxOrd.name + " " + count + resultingResidentsForOrd.toString());
			Iterator<String> weaponIter = residentsMap.keySet().iterator();
			while(weaponIter.hasNext()){
				if(countResidentsForWeapon>=maxWeapon.size)break;
				String resName = weaponIter.next();
				if(!occupiedResidents.contains(resName)){
					countResidentsForWeapon++;
					resultingResidentsForWeapon.add(resName);
					occupiedResidents.add(resName);
				}
			}
			Iterator<String> armorIter = residentsMap.keySet().iterator();
			while(armorIter.hasNext()){
				if(countResidentsForArmor>=maxArmor.size)break;
				String resName = armorIter.next();
				if(!occupiedResidents.contains(resName)){
					countResidentsForArmor++;
					resultingResidentsForArmor.add(resName);
					occupiedResidents.add(resName);
				}
			}
			Iterator<String> ordIter = residentsMap.keySet().iterator();
			while(ordIter.hasNext()){
				if(countResidentsForOrd>=maxOrd.size)break;
				String resName = ordIter.next();
				if(!occupiedResidents.contains(resName)){
					countResidentsForOrd++;
					resultingResidentsForOrd.add(resName);
					occupiedResidents.add(resName);
				}
			}
			
			StringBuffer sbWeapon = new StringBuffer();
			for(String resName : resultingResidentsForWeapon){
				sbWeapon.append(" " + resName);
			}
			System.out.println(maxWeapon.name + " " + countResidentsForWeapon + sbWeapon.toString());
			StringBuffer sbArmor = new StringBuffer();
			for(String resName : resultingResidentsForArmor){
				sbArmor.append(" " + resName);
			}
			System.out.println(maxArmor.name + " " + countResidentsForArmor + sbArmor.toString());
			StringBuffer sbOrd = new StringBuffer();
			for(String resName : resultingResidentsForOrd){
				sbOrd.append(" " + resName);
			}
			System.out.println(maxOrd.name + " " + countResidentsForOrd + sbOrd.toString());
		}		
	}
}
