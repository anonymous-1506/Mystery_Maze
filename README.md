<h1>Game-a-Thon</h1>
<h2>Mystery_Maze</h2>
<h3>Milestones met until now:</h3>
<ol>
  <li>Milestone 1:
  <p>Requirements</p>
  <ul>
    <li>Implement a basic maze generation algorithm, such as depth-first search or recursive backtracking.</li>
    <li>Ensure the paths lead to dead ends, exit doors, or hidden treasures.</li>
    <li>Introduce spike obstacles that the player must avoid.</li>
    <li>Randomly generate the maze each time for enhanced replayability.</li>
  </ul>
    <p>Implementations for the same</p>
    <ul>
      <li>For generating the maze, I used the a DFS based Algorithm.
      <li>The paths as of now lead to a Door(at roughly the top of the maze),a Treasure Chest (roughly the center or middle portion) and a lot of dead ends.
      <li>There are spike obstacles that are generated randomly(number of them : 1 to 4 randomly , can make it level dependent later).
      <li>The maze generated as of now is uniques for every gameplay.
    </ul>
    <img src = "https://github-production-user-asset-6210df.s3.amazonaws.com/148906347/346294019-b0203f25-4c06-4391-b17a-acfcc8f0136c.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240706%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240706T191742Z&X-Amz-Expires=300&X-Amz-Signature=bf1157f623ec13df6624a6e001d26307c00672ceff9f6a0c8ecb280e0403f726&X-Amz-SignedHeaders=host&actor_id=148906347&key_id=0&repo_id=824835899" height = "720" width = "960" >
  </li>
<li>
  Milestone 2:
  <p>Requirements</p>
  <ul>
    <li>Allow the player character to move left, right, up, and down using touch controls, WASD keys, or arrow keys.
    <li>Implement player movement and collision detection with maze walls.
    <li>Enable the spacebar or a double-tap key to drop a bomb.
  </ul>
  <p>Implementations</p>
  <ul>
    <li>The Player movements are controlled by UP/DOWN... Arrow keys.
    <li>Collision system with Maze walls, Door(prior to key collection) and spiked walls.
    <li>Spacebar now deploys a bomb(3m in number at the start of the game).
  </ul>
<img src ""  height = "" width = "" >
</ol>
