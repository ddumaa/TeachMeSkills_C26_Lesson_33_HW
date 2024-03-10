package by.tms.service;

import by.tms.model.Operation;
import by.tms.storage.DBOperationSave;

public class OperationService {

    public Operation calculate(Operation operation) {
        switch (operation.getType()) {
            case "+":
                operation.setResult(operation.getNum1() + operation.getNum2());
                DBOperationSave.operationSave(operation);
                return operation;
            case "-":
                operation.setResult(operation.getNum1() - operation.getNum2());
                DBOperationSave.operationSave(operation);
                return operation;
            case "*":
                operation.setResult(operation.getNum1() * operation.getNum2());
                DBOperationSave.operationSave(operation);
                return operation;
            case "/":
                operation.setResult(operation.getNum1() / operation.getNum2());
                DBOperationSave.operationSave(operation);
                return operation;
        }
        throw new IllegalArgumentException();
    }
}