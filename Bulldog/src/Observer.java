/********************************************************/
/* Courtney Jackson                                     */
/* Login ID: courtney.jackson@maine.edu                 */
/* COS 420, Spring 2025                                 */
/* Observer interface: defines the contract for         */
/* objects that observe changes in game state           */
/********************************************************/
public interface Observer {
    void update(GameStatus status);
}

