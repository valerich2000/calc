package com.company;

public class Parser {

    /**
     * возвращаю обьект который содержит всю информацию для дальнейшей обработки
     * @param source
     * @return
     */
    public ResultInfo parse(String source) {
        String operationType = getOperationType(source);
        String[] elements = getElements(source, operationType);

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.elements = elements;
        resultInfo.operationType = operationType;
        return resultInfo;
    }

    /**
     * определение типа операции
     * @param source - введенная строка
     * @return - тип операции (можно переделать чтобы возвращать Enum где будут перечислены операции)
     */
    private String getOperationType(String source) {
        String result = "";

        if (source.contains("+")) {
            result = "add";
        } else if (source.contains("-")) {
            result = "subtract";
        } else if (source.contains("*")) {
            result = "multiply";
        } else if (source.contains("/")) {
            result = "divide";
        } else {
            throw new IllegalArgumentException("Bad incoming parameters.");
        }
        return result;
    }

    /**
     * получение значений операндов из входной строки
     * @return
     */
    private String[] getElements(String source, String operationType) {
        String[] result = null;
        if (operationType.equals("add")) {
            result = source.split("\\+");
        } else if (operationType.equals("subtract")) {
            result = source.split("-");
        } else if (operationType.equals("multiply")) {
            result = source.split("\\*");
        } else if (operationType.equals("divide")) {
            result = source.split("/");
        }
        return result;
    }
}
