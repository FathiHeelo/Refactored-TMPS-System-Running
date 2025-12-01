package TMPS.Solution.connection;


public class DataBaseService implements QueryExecutor {
    @Override
    public void executeQuery(Connection connection, String q) {
        System.out.println("[Conn " + connection.getId() + "] Executing query: " + q);

    }
}
