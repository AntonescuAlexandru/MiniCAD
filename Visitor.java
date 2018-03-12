public interface Visitor {
    void visit(Canvas canvas);
    void visit(Line line);
    void visit(Square square);
    void visit(Rectangle rectangle);
    void visit(Circle circle);
    void visit(Triangle triangle);
    void visit(Diamond diamond);
    void visit(Polygon polygon);
}
