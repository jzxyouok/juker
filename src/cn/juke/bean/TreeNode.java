package cn.juke.bean;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_treenode",catalog="juker")
public class TreeNode  implements java.io.Serializable {  
  
    
    private Long id;  
  
    private String name;  
    // 父节点  
    private TreeNode parent;  
    
    private String url;
    
    private Set<TreeNode> children = new LinkedHashSet<TreeNode>();  
    
    public String getUrl() {
		return url;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", name=" + name + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 子节点  
   
  
    public TreeNode() {  
    }  
  
    public TreeNode(String name) {  
        this.name = name;  
    }  
    
    
    @Id  
    @Column(name = "ID")  
    @GeneratedValue  
    public Long getId() {  
        return id;  
    }  
  
    @Column(name = "NAME", length = 20)  
    public String getName() {  
        return name;  
    }  
  
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
    @JoinColumn(name = "PARENT_ID")  
    public TreeNode getParent() {  
        return parent;  
    }  
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.LAZY)  
    public Set<TreeNode> getChildren() {  
        return children;  
    }  
  
    public void setId(Long id) {  
        this.id = id;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public void setParent(TreeNode parent) {  
        this.parent = parent;  
    }  
  
    public void setChildren(Set<TreeNode> children) {  
        this.children = children;  
    }


	public TreeNode(Long id, String name, TreeNode parent, String url,
			Set<TreeNode> children) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.url = url;
		this.children = children;
	}  
}  