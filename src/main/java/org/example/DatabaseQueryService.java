package org.example;

import org.example.resultset.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbUtil.readSqlFile;

public class DatabaseQueryService {
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        for (FindLongestProject findLongestProject : queryService.setFindLongestProject()) {
            System.out.println(findLongestProject);
        }

        for (MaxProjectCountClient maxProjectCountClient : queryService.findMaxProjectsClient()) {
            System.out.println(maxProjectCountClient);
        }

        for (MaxSalaryWorker maxSalaryWorker : queryService.findMaxSalaryWorker()) {
            System.out.println(maxSalaryWorker);
        }

        for (ProjectPrice printProjectPrice : queryService.printProjectPrices()) {
            System.out.println(printProjectPrice);
        }

        for (YoungestEldestWorkers youngestEldestWorker : queryService.findYoungestEldestWorkers()) {
            System.out.println(youngestEldestWorker);
        }
    }

    private List<FindLongestProject> setFindLongestProject() {
        List<FindLongestProject> projectsList = new ArrayList<>();
        String sqlQuery = readSqlFile(DatabaseProperty.findLongestProject());
        Connection connection = Database.getInstance().getConnection();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                projectsList.add(new FindLongestProject(
                        resultSet.getLong("project_id"),
                        resultSet.getBigDecimal("month_count")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectsList;
    }

    private List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> projectCountList = new ArrayList<>();
        String sqlQuery = readSqlFile(DatabaseProperty.findMaxProjectsClient());
        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                projectCountList.add(new MaxProjectCountClient(
                        resultSet.getString("name"),
                        resultSet.getLong("count")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectCountList;
    }

    private List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryList = new ArrayList<>();
        String sqlQuery = readSqlFile(DatabaseProperty.findMaxSalaryWorker());
        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                maxSalaryList.add(new MaxSalaryWorker(
                        resultSet.getString("name"),
                        resultSet.getInt("salary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxSalaryList;
    }

    private List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> projectPriceList = new ArrayList<>();
        String sqlQuery = readSqlFile(DatabaseProperty.printProjectPrices());
        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                projectPriceList.add(new ProjectPrice(
                        resultSet.getLong("project_id"),
                        resultSet.getBigDecimal("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectPriceList;
    }

    private List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> workerList  = new ArrayList<>();
        String sqlQuery = readSqlFile(DatabaseProperty.findYoungestEldestWorkers());
        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                workerList.add(new YoungestEldestWorkers(
                        resultSet.getString("type"),
                        resultSet.getString("name"),
                        LocalDate.parse(resultSet.getString("birthday"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workerList;
    }
}
