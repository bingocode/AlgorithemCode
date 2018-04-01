package designpattern;

import java.util.ArrayList;

public class WordDocument implements Cloneable{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected WordDocument clone(){//因为clone不屌用构造函数，所以需要注意若构造函数内有特殊逻辑处理情况
        try{
            WordDocument doc = (WordDocument) super.clone();
            doc.text = this.text; //浅拷贝：将副本文档字段引用指向原始文档字段（若）
            return doc;
        }catch (Exception e){
        }
        return null;
    }
    public static void main(String[] args){
        WordDocument d0 = new WordDocument();
        d0.setText("a");
        WordDocument d2 = d0.clone();
        System.out.println(d2.getText());

        d0.setText("b");
        System.out.println(d2.getText());


    }
}
