package com.acme;

public class PrintActivity extends Activity {
    
    // Atributes
    private int startPage;
    private int endPage;
    private String document;
    private PageSize pageSize;
    
    enum PageSize {
        A1,A2,A3,A4,A5;
    }
        
    // Contrutor
    public PrintActivity() {
        super();
    }
    
    public PrintActivity(String name) {
        super(name);
    }
    
    
    // Operations

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }
    
    @Override
    public void setName(String name) {
        if (name.length() >=4 && name.length() <=10) {
            super.name = name;
        }
    }
    
            
}
