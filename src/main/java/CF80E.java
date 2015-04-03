import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

public class CF80E {

	public static class State {
		String uuid = null;
		int[] pos = new int[3];
		boolean[] alreadyMoved = new boolean[3];
		boolean[] alreadyThrown = new boolean[3];
		short[] maxMove = new short[3];
		short[] maxThrow = new short[3];
		boolean[][] holds = new boolean[3][3];
		String desc = null;

		public boolean canMove(int who) {
			boolean holdsSomeOne = holdsSomeOne(who);
			boolean isHeld = isHeld(who);
			return !alreadyMoved[who] && !holdsSomeOne && !isHeld;
		}

		private boolean isHeld(int who) {
			boolean isHeld = false;
			for (int j = 0; j < 3; j++) {
				if (who == j)
					continue;
				isHeld |= holds[j][who];
			}
			return isHeld;
		}

		private boolean holdsSomeOne(int who) {
			boolean holdsSomeOne = false;
			for (int j = 0; j < 3; j++) {
				if (who == j)
					continue;
				holdsSomeOne |= holds[who][j];
			}
			return holdsSomeOne;
		}

		public boolean canTake(int who) {
			boolean holdsSomeOne = holdsSomeOne(who);
			boolean isHeld = isHeld(who);
			return !alreadyThrown[who] && !holdsSomeOne && !isHeld;
		}

		public boolean canBeTaken(int who) {
			return !isHeld(who);
		}

		public void take(int who, int whom) {
			holds[who][whom] = true;
		}

		public boolean canThrow(int who, int whom) {
			boolean isHeld = isHeld(who);
			return holds[who][whom] && !isHeld;
		}

		public int getMaxPos() {
			return Math.max(pos[0], Math.max(pos[1], pos[2]));
		}

		public State clone() {
			State newState = new State();
			newState.pos = pos.clone();
			newState.alreadyMoved = alreadyMoved.clone();
			newState.alreadyThrown = alreadyThrown.clone();
			newState.maxMove = maxMove.clone();
			newState.maxThrow = maxThrow.clone();
			newState.holds = holds.clone();
			for (int i = 0; i < newState.holds.length; i++) {
				newState.holds[i] = holds[i].clone();
			}
			return newState;
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("pos:");
			for (int i = 0; i < pos.length; i++) {
				if (i != 0)
					sb.append(",");
				sb.append(pos[i]);
			}
			sb.append("\n");
			sb.append("alreadyMoved:");
			for (int i = 0; i < alreadyMoved.length; i++) {
				if (i != 0)
					sb.append(",");
				sb.append(alreadyMoved[i]);
			}
			sb.append("\n");
			sb.append("alreadyThrown:");
			for (int i = 0; i < alreadyThrown.length; i++) {
				if (i != 0)
					sb.append(",");
				sb.append(alreadyThrown[i]);
			}
			sb.append("\n");
			sb.append("holds:\n");
			for (int i = 0; i < holds.length; i++) {
				sb.append(i + ": ");
				for (int j = 0; j < holds[0].length; j++) {
					if (i == j)
						continue;
					sb.append(holds[i][j] + " ");
				}
				sb.append("\n");
			}
			sb.append("Description:" + desc + "\n");
			return sb.toString();
		}
	}

	public static int getPartner(int who, boolean isFirst) {
		return (who + (isFirst ? 1 : 2)) % 3;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		State initialState = new State();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int cnt = 0;
		initialState.pos[cnt] = Integer.parseInt(parts[0]);
		initialState.maxMove[cnt] = Short.parseShort(parts[1]);
		initialState.maxThrow[cnt] = Short.parseShort(parts[2]);
		parts = br.readLine().split("\\s+");
		++cnt;
		initialState.pos[cnt] = Integer.parseInt(parts[0]);
		initialState.maxMove[cnt] = Short.parseShort(parts[1]);
		initialState.maxThrow[cnt] = Short.parseShort(parts[2]);
		parts = br.readLine().split("\\s+");
		++cnt;
		initialState.pos[cnt] = Integer.parseInt(parts[0]);
		initialState.maxMove[cnt] = Short.parseShort(parts[1]);
		initialState.maxThrow[cnt] = Short.parseShort(parts[2]);
		// initialState.uuid = UUID.randomUUID().toString();
		// bfs(initialState);
		// dfs(initialState,1);
		bfs(initialState);
		System.out.println(maxPos);
	}

	public static int maxPos = Integer.MIN_VALUE;

	private static void dfs(State state, int depth) {
		int cnt;
		boolean[] partners = { true, false };
		int iterations = 0;
		// Map<String,State> mapForPrevs = new HashMap<String, State>();
		int currPos = state.getMaxPos();
		if (maxPos < currPos) {
			maxPos = currPos;
			System.out.print("maxPos=" + maxPos + ",depth=" + depth + ","
					+ state.toString());
			// if(maxPos == 16)
			// printPrevStates(state, mapForPrevs);
		}

		for (cnt = 0; cnt < 3; cnt++) {
			if (state.canMove(cnt)) {
				for (int i = -state.maxMove[cnt]; i <= state.maxMove[cnt]; i++) {
					if (i == 0)
						continue;
					if (state.pos[cnt] + i != state.pos[getPartner(cnt, true)]
							&& state.pos[cnt] + i != state.pos[getPartner(cnt,
									false)]) {
						State newState = state.clone();
						newState.pos[cnt] += i;
						newState.alreadyMoved[cnt] = true;
						dfs(newState, depth + 1);

						// newState.desc = "Moved to this state " + i + " steps"
						// + ", iteration:" + iterations;
						// newState.uuid = UUID.randomUUID().toString();
						// mapForPrevs.put(newState.uuid, state);
					}
				}
			}
		}

		for (cnt = 0; cnt < 3; cnt++) {
			if (state.canTake(cnt)) {
				for (int partner = 0; partner < partners.length; partner++) {
					if (Math.abs(state.pos[cnt]
							- state.pos[getPartner(cnt, partners[partner])]) == 1) {
						State newState = state.clone();
						newState.take(cnt, getPartner(cnt, partners[partner]));
						newState.pos[getPartner(cnt, partners[partner])] = newState.pos[cnt];
						dfs(newState, depth + 1);

						// newState.desc = "Taken to this state" +
						// ", iteration:" + iterations;
						// newState.uuid = UUID.randomUUID().toString();
						// mapForPrevs.put(newState.uuid, state);
					}
				}
			}
		}
		for (cnt = 0; cnt < 3; cnt++) {
			for (int partner = 0; partner < partners.length; partner++) {
				if (state.canThrow(cnt, getPartner(cnt, partners[partner]))) {
					// for (int thrw = -state.maxThrow[cnt]; thrw <=
					// state.maxThrow[cnt]; thrw++) {
					for (int thrw = 1; thrw <= state.maxThrow[cnt]; thrw++) {
						if (thrw == 0)
							continue;
						if (state.pos[cnt] + thrw != state.pos[getPartner(cnt,
								!partners[partner])]) {
							State newState = state.clone();
							newState.holds[cnt][getPartner(cnt,
									partners[partner])] = false;
							if (newState.holds[getPartner(cnt,
									partners[partner])][getPartner(cnt,
									!partners[partner])]) {
								newState.pos[getPartner(cnt, !partners[partner])] = newState.pos[cnt]
										+ thrw;
							}
							newState.alreadyThrown[cnt] = true;
							newState.pos[getPartner(cnt, partners[partner])] = newState.pos[cnt]
									+ thrw;
							dfs(newState, depth + 1);

							// newState.desc = "Thrown to this state " + thrw +
							// " steps" + ", iteration:" + iterations;
							// newState.uuid = UUID.randomUUID().toString();
							// mapForPrevs.put(newState.uuid, state);
						}
					}
				}
			}
		}
	}

	private static void bfs(State initialState) {
		int cnt;
		boolean[] partners = { true, false };
		// int maxPos = Integer.MIN_VALUE;
		Queue<State> queue = new LinkedList<State>();
		queue.add(initialState);
		int iterations = 0;
		// Map<String,State> mapForPrevs = new HashMap<String, State>();
		while (!queue.isEmpty()) {
			++iterations;
			State state = queue.poll();
			int currPos = state.getMaxPos();
			if (maxPos < currPos) {
				maxPos = currPos;
				System.out.print("maxPos=" + maxPos + ",iter=" + iterations
						+ "," + state.toString());
				// if(maxPos == 16)
				// printPrevStates(state, mapForPrevs);
			}

			for (cnt = 0; cnt < 3; cnt++) {
				if (state.canMove(cnt)) {
					 for (int i = -state.maxMove[cnt]; i <= state.maxMove[cnt]; i++) {					
						if (i == 0)
							continue;
						if (state.pos[cnt] + i != state.pos[getPartner(cnt,
								true)]
								&& state.pos[cnt] + i != state.pos[getPartner(
										cnt, false)]) {
							State newState = state.clone();
							newState.pos[cnt] += i;
							newState.alreadyMoved[cnt] = true;
							queue.add(newState);

							// newState.desc = "Moved to this state " + i +
							// " steps" + ", iteration:" + iterations;
							// newState.uuid = UUID.randomUUID().toString();
							// mapForPrevs.put(newState.uuid, state);
						}
					}
				}
			}

			for (cnt = 0; cnt < 3; cnt++) {
				if (state.canTake(cnt)) {
					for (int partner = 0; partner < partners.length; partner++) {
						if (Math.abs(state.pos[cnt]
								- state.pos[getPartner(cnt, partners[partner])]) == 1 && state.canBeTaken(getPartner(cnt, partners[partner]))) {
							State newState = state.clone();
							newState.take(cnt,
									getPartner(cnt, partners[partner]));
							newState.pos[getPartner(cnt, partners[partner])] = newState.pos[cnt];
							queue.add(newState);

							// newState.desc = "Taken to this state" +
							// ", iteration:" + iterations;
							// newState.uuid = UUID.randomUUID().toString();
							// mapForPrevs.put(newState.uuid, state);
						}
					}
				}
			}
			for (cnt = 0; cnt < 3; cnt++) {
				for (int partner = 0; partner < partners.length; partner++) {
					if (state.canThrow(cnt, getPartner(cnt, partners[partner]))) {
						for (int thrw = -state.maxThrow[cnt]; thrw <= state.maxThrow[cnt]; thrw++) {
							if (thrw == 0)
								continue;
							if (state.pos[cnt] + thrw != state.pos[getPartner(
									cnt, !partners[partner])]) {
								State newState = state.clone();
								newState.holds[cnt][getPartner(cnt,
										partners[partner])] = false;
								if (newState.holds[getPartner(cnt,
										partners[partner])][getPartner(cnt,
										!partners[partner])]) {
									newState.pos[getPartner(cnt,
											!partners[partner])] = newState.pos[cnt]
											+ thrw;
								}
								newState.alreadyThrown[cnt] = true;
								newState.pos[getPartner(cnt, partners[partner])] = newState.pos[cnt]
										+ thrw;
								queue.add(newState);

								// newState.desc = "Thrown to this state " +
								// thrw + " steps" + ", iteration:" +
								// iterations;
								// newState.uuid = UUID.randomUUID().toString();
								// mapForPrevs.put(newState.uuid, state);
							}
						}
					}
				}
			}
		}
		// System.out.println(maxPos);
		// System.out.println(iterations);
	}

	private static void printPrevStates(State state,
			Map<String, State> mapForPrevs) {
		if (state == null) {
			System.out.println("----------------------------------------");
			return;
		}
		System.out.println(state.toString());
		System.out.println();
		State prev = mapForPrevs.get(state.uuid);
		printPrevStates(prev, mapForPrevs);
	}
}
